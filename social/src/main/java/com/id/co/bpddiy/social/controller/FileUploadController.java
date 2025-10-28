package com.id.co.bpddiy.social.controller;

import com.id.co.bpddiy.social.dto.FileUploadResponse;
import com.id.co.bpddiy.social.dto.UserDto;
import com.id.co.bpddiy.social.security.UserPrincipal;
import com.id.co.bpddiy.social.service.FileStorageService;
import com.id.co.bpddiy.social.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;

/**
 * Controller untuk file upload, download, dan delete.
 */
@RestController
@RequestMapping("/api/files")
public class FileUploadController {
    private final FileStorageService fileStorageService;
    @Autowired
    private UserService userService;

    public FileUploadController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    /**
     * Upload file umum
     * Endpoint: POST /api/files/upload
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Upload File", description = "Upload satu file ke server")
    public FileUploadResponse uploadFile(
            @RequestParam("file") MultipartFile file,
            @AuthenticationPrincipal UserPrincipal currentUser
    ) {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/files/download/")
                .path(fileName)
                .toUriString();

        return new FileUploadResponse(
                fileName,
                fileDownloadUri,
                file.getContentType(),
                file.getSize(),
                currentUser.getUsername());
    }

    /**
     * Download file
     * Endpoint: GET /api/files/download/{fileName}
     */
    @GetMapping("/download/{fileName:.+}")
    @Operation(summary = "Download File", description = "Download file berdasarkan nama file")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable String fileName,
            HttpServletRequest request
    ) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        if (resource == null) {
            return ResponseEntity.notFound().build();
        }

        String contentType;
        try {
            contentType = request.getServletContext()
                    .getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            contentType = null;
        }

        // Fallback to default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    /**
     * Upload profile image user
     * Endpoint: POST /api/files/profile-image
     */
    @PostMapping("/profile-image")
    public ResponseEntity<UserDto> uploadProfileImage(
            @RequestParam("file") MultipartFile file,
            @AuthenticationPrincipal UserPrincipal currentUser) {

        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/files/download/")
                .path(fileName)
                .toUriString();

        UserDto updatedUser = userService.updateProfileImage(currentUser.getId(), fileDownloadUri);

        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete file
     * Endpoint: DELETE /api/files/{fileName}
     */
    @DeleteMapping("/{fileName:.+}")
    public ResponseEntity<String> deleteFile(
            @PathVariable String fileName,
            @AuthenticationPrincipal UserPrincipal currentUser
    ) {
        boolean deleted = fileStorageService.deleteFile(fileName);

        if (deleted) {
            return ResponseEntity.ok("File deleted successfully: " + fileName);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}