package com.lenech.lab4.controller;
import com.lenech.lab4.model.Chat;
import com.lenech.lab4.repository.ChatRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/in")
public class ChatController {
    private ChatRepository chatRepository;
    @Autowired
    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping("/chat")
    public List<Chat> getAllChat(){
        return chatRepository.findAll();
    }
    @PostMapping("/chat")
    public Chat createChat(@Valid @RequestBody Chat chat){
        return chatRepository.save(chat);
    }

    @GetMapping("/chat/{id}")
    public ResponseEntity<Chat> getChatId(@PathVariable(value = "id")int chatId)
            throws ResourceNotFoundException {
        Chat chat = chatRepository.findById(chatId).orElseThrow(()->
                new ResourceNotFoundException("Chat not found"));
        return ResponseEntity.ok().body(chat);
    }

    @DeleteMapping("/chat/{id}")
    public Map<String, Boolean> deleteChat(@PathVariable(value = "id")int chatId)
            throws ResourceNotFoundException{
        Chat chat = chatRepository.findById(chatId).orElseThrow(()-> new ResourceNotFoundException("Chat not found"));
        chatRepository.delete(chat);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete",Boolean.TRUE);
        return response;
    }

    @PutMapping("/chat/{id}")
    public ResponseEntity<Chat> updateChat(@PathVariable(value = "id") int chatId,
                                           @Valid @RequestBody Chat chatdetails)
            throws ResourceNotFoundException{
        Chat chat = chatRepository.findById(chatId).orElseThrow(()-> new
                ResourceNotFoundException("Chat not found"));
        chat.setTitle(chatdetails.getTitle());
        chat.setLink(chatdetails.getLink());

        final Chat updatedChat = chatRepository.save(chat);
        return ResponseEntity.ok(updatedChat);
    }
}
