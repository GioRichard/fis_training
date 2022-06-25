package com.fis.sprint4.controller;

import com.fis.sprint4.model.TrackEntry;
import com.fis.sprint4.service.TrackEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/trackEntry")
@CrossOrigin("*")
public class TrackEntryController {
    final
    TrackEntryService trackEntryService;

    public TrackEntryController(TrackEntryService trackEntryService) {
        this.trackEntryService = trackEntryService;
    }

    @GetMapping("/")
    public Set<TrackEntry> getTrackEntries() {
        return this.trackEntryService.getTrackEntries();
    }

    @PostMapping("/")
    public ResponseEntity<TrackEntry> addTrackEntry(@RequestBody TrackEntry trackEntry) {
        return ResponseEntity.ok(this.trackEntryService.addTrackEntry(trackEntry));
    }

    @PutMapping("/")
    public TrackEntry updateTrackEntry(@RequestBody TrackEntry trackEntry) {
        return this.trackEntryService.updateTrackEntry(trackEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteTrackEntry(@PathVariable Long id) {
        this.trackEntryService.deleteTrackEntry(id);
    }
}