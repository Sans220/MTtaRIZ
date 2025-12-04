package com.ontu.lab6.controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@ComponentScan("com.ontu.lab6.controller")

public class WebController 
{

    @RequestMapping(value = "/index")
   public String index(Model model) 
   {
        // Example game board state: 'X', 'O', or ' ' for empty cells
        char[][] board = {
            {'O', 'X', 'X'},
            {'X', 'X', 'O'},
            {'O', 'O', 'X'}
        };
        
        model.addAttribute("board", board);
        return "index";
    }
}
