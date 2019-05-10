package com.example.demoexcel.controller;

import com.example.demoexcel.entity.Person;
import com.example.demoexcel.repository.PersonRepository;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("export")
    String export() {

        //Ctrl+Alt+V+回车   可以自动补全代码的句柄
        //查询100万数据
        final List<Person> personList = personRepository.findAll();

        System.out.println(personList.size());


        //写数据开始
        System.out.println("##################################开始写数据");
        String fileName = "hello100000.xlsx";

        XSSFWorkbook workbook1 = new XSSFWorkbook();
        SXSSFWorkbook workbook = new SXSSFWorkbook(workbook1, 100);
        Sheet sheet = workbook.createSheet("cat");
        Row row = sheet.createRow(0);

        List<String> title_list = new ArrayList<>();

        title_list.add("id");
        title_list.add("address");
        title_list.add("age");
        title_list.add("name");


        for (int i = 0; i < title_list.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(title_list.get(i));
        }

        for (int i = 0; i < personList.size(); i++) {
            Row rowData = sheet.createRow(i + 1);
            Person person = personList.get(i);

            rowData.createCell(0).setCellValue(person.getId());
            rowData.createCell(1).setCellValue(person.getAddress());
            rowData.createCell(2).setCellValue(person.getAge());
            rowData.createCell(3).setCellValue(person.getName());

        }

        String pathname = "D:\\file\\excel\\" + fileName;


        try (OutputStream stream = new FileOutputStream(new File(pathname))) {
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("##################################结束写数据");

        return "export success";

    }


}
