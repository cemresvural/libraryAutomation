package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.CreateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Dtos.Administrator.UpdateAdministratorDto;
import com.kutuphane.kutuphaneotomasyon.Entities.Administrator;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrator")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService administratorService;
    @GetMapping
    public List<Administrator> getAll()
    {
        return administratorService.getAll();
    }
   @GetMapping("getById")
    public Administrator getById(int id)
    {
        return administratorService.getById(id);
    }
    @PostMapping("create")
    public void add(@RequestBody CreateAdministratorDto dto)
    {
        administratorService.add(dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        administratorService.delete(id);

    }
    @PutMapping("update")
    public void update(@RequestBody UpdateAdministratorDto dto)
    {
        administratorService.update(dto);
    }
}
