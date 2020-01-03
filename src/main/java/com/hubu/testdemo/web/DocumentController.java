package com.hubu.testdemo.web;

import com.hubu.testdemo.entity.Document;
import com.hubu.testdemo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    @GetMapping(value = "/findDocumentByName")
    public List<Document> findDocumentByName(@RequestParam("documentName")String documentName) {
        List<Document> documents = documentService.findDocumentByName(documentName);
        return documents;
    }
    @GetMapping(value = "/findDocumentByUploadTime")
    public List<Document> findDocumentByUploadTime(@RequestParam("uploadTime")String uploadTime) {
        List<Document> documents = documentService.findDocumentByUploadTime(uploadTime);
        return  documents;
    }

    @GetMapping(value = "/findDocumentBySize")
    public List<Document> findDocumentBySize(@RequestParam("size")long size) {
        List<Document> documents =  documentService.findDocumentByDocumentSize(size);
        return documents;
    }

    @GetMapping(value = "/findDocumentAmount")
    public int findDocumentAmount() {
        int amount = documentService.findDocumentAmount();
        return amount;
    }

    @PostMapping(value = "/addDocument")
    public boolean addDocument(@RequestParam("sourceUrl")String sourceUrl, @RequestParam("documentName") String documentName) {
        //增加音乐文件的结果
        Document document = new Document();
        document.setSourceUrl(sourceUrl);
        document.setName(documentName);
        return documentService.addDocumentFile(document);
    }

    @DeleteMapping(value = "/deleteDocument")
    @Transactional
    public void deleteDocument(@RequestParam("fileName") String fileName) {
        documentService.deleteDocumentFile(fileName);
    }
    @GetMapping("/downloadDocument")
    public void downloadDocument(@RequestParam("destinationUrl") String destinationUrl,@RequestParam("localPath") String localPath){
        documentService.downloadDocument(destinationUrl,localPath);
    }
}
