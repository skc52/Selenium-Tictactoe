package com.ea.SpringMvn;

import com.example.tictactoe.Game;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
@RequestMapping(path="/")
public class SpringMvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvnApplication.class, args);
	}


	@GetMapping
	public String hello(){
		return "<html><body><h1>Hello UPS</h1></body></html>";	}

//	@Controller
//	public static class GameController {
//		private Game game;
//
//		public GameController() {
//			game = new Game();
//		}
//
//		@GetMapping("/game")
//		public String showGame(Model model) {
//			model.addAttribute("game", game);
//			return "game";
//		}
//
//		@PostMapping("/game/move")
//		@ResponseBody
//		public String makeMove(@RequestParam int row, @RequestParam int col) {
//			if (game.makeMove(row, col)) {
//				if (game.checkWin()) {
//					return "win";
//				} else if (game.checkDraw()) {
//					return "draw";
//				} else {
//					game.switchPlayer();
//					return "success";
//				}
//			}
//			return "invalid";
//		}
//
//		@PostMapping("/game/reset")
//		public String resetGame() {
//			game = new Game();
//			return "redirect:/game";
//		}
//	}

	@Controller
	public static class GameController {
		private static final String SESSION_GAME_KEY = "game";

		@GetMapping("/game")
		public String showGame(Model model, HttpSession session) {
			// Get the game instance from the session or create a new one
			Game game = (Game) session.getAttribute(SESSION_GAME_KEY);
			if (game == null) {
				game = new Game();
				session.setAttribute(SESSION_GAME_KEY, game);
			}

			model.addAttribute("game", game);
			return "game";
		}

		@PostMapping("/game/move")
		@ResponseBody
		public String makeMove(@RequestParam int row, @RequestParam int col, HttpSession session) {
			Game game = (Game) session.getAttribute(SESSION_GAME_KEY);
			if (game != null) {
				if (game.makeMove(row, col)) {
					if (game.checkWin()) {
						session.removeAttribute(SESSION_GAME_KEY); // Remove the game from session after a win
						return "win";
					} else if (game.checkDraw()) {
						session.removeAttribute(SESSION_GAME_KEY); // Remove the game from session after a draw
						return "draw";
					} else {
						game.switchPlayer();
						return "success";
					}
				}
				return "invalid";
			}
			return "error";
		}

		@PostMapping("/game/reset")
		public String resetGame(HttpSession session) {
			session.removeAttribute(SESSION_GAME_KEY); // Remove the game from session to reset
			return "redirect:/game";
		}
	}




}


