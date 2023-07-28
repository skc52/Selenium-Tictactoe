package com.example.controller;
import com.example.tictactoe.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game")
public class GameController {
    private Game game;

    public GameController() {
        game = new Game();
    }

    @GetMapping("/")
    public String showGame(Model model) {
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping("/move")
    @ResponseBody
    public String makeMove(@RequestParam int row, @RequestParam int col) {
        if (game.makeMove(row, col)) {
            if (game.checkWin()) {
                return "win";
            } else if (game.checkDraw()) {
                return "draw";
            } else {
                game.switchPlayer();
                return "success";
            }
        }
        return "invalid";
    }

    @PostMapping("/reset")
    public String resetGame() {
        game = new Game();
        return "redirect:/";
    }
}
