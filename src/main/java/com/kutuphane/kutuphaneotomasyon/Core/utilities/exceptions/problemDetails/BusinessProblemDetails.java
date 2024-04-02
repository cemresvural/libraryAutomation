package com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.problemDetails;

public class BusinessProblemDetails extends ProblemDetails{
    public BusinessProblemDetails(){
        setTitle("Is kuralları hataları");
        setType("http://mydomain.com/exceptions/business");
        setStatus("400");
    }
}
