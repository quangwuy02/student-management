package org.example.huydq.controller;

import org.example.huydq.entity.Class;
import org.example.huydq.service.classes.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/all-classes")
    public List<Class> getAllClasses() {

        return classService.getAllClasses();
    }

    @PostMapping("/new-class")
    public Class createClass(@RequestBody Class lop) {
        return classService.saveClass(lop);
    }

    @PutMapping("/edit-class/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class classDetails) {
        Optional<Class> lop = classService.getClassById(id);
        if (lop.isPresent()) {
            Class updatedClass = lop.get();
            updatedClass.setName(classDetails.getName());
            updatedClass.setDepartment(classDetails.getDepartment());
            return ResponseEntity.ok(classService.saveClass(updatedClass));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-class/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        classService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}
