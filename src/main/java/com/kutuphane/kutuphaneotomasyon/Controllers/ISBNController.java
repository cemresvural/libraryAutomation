package com.kutuphane.kutuphaneotomasyon.Controllers;

import com.kutuphane.kutuphaneotomasyon.Dtos.ISBN.CreateISBNDto;
import com.kutuphane.kutuphaneotomasyon.Entities.ISBN;
import com.kutuphane.kutuphaneotomasyon.Services.abstracts.ISBNService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ISBN")
@RequiredArgsConstructor
public class ISBNController {
    private final ISBNService isbnService;
    @GetMapping
    public List<ISBN> getAll()
    {
        return isbnService.getAll();
    }
    @GetMapping("getById")
    public void getById(int id)
    {
         isbnService.getById(id);
    }
    @PostMapping("create")
    public void createISBN(@RequestBody CreateISBNDto dto)
    {
        isbnService.add(dto);
    }
    @DeleteMapping("delete")
    public void deleteISBN(@RequestParam int id)
    {
        isbnService.delete(id);


    }
    @PutMapping("update")
    public void updateGenres(ISBN isbn)
    {
        isbnService.update(isbn);

    }
}
