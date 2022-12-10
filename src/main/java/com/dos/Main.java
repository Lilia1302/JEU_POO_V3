package com.dos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    
    public static void main(String[] args) {

        final List<String> playerIds = new ArrayList<String>();
        final int PLAYER_COUNT = 3;

        for(int i = 1; i <= PLAYER_COUNT; i++) {
            playerIds.add("Joueur " + i);
        }

        Game game = new Game(playerIds);
        game.start(game);

        final Queue<String> players = new LinkedList<>();
        
        players.addAll(playerIds);

        int round = 0;

        while (players.size() > PLAYER_COUNT - 1) {
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("Round " + ++round + " : c'est au tour de " + game.getCurrentPlayer() + " !\n");
            
            for (int j = 0; j < PLAYER_COUNT; j++) {
                System.out.println("Main de " + game.getPlayers().get(j) +  " : " + game.getPlayerHand(game.getPlayers().get(j)).toString());
            }

            System.out.println("\nStockPile : " + game.getStockPile() + "\n");
            
            String firstPlayerInRound = players.poll();
            players.offer(firstPlayerInRound);

            game.submitPlayerCard(firstPlayerInRound);

            if (game.hasEmptyHand(firstPlayerInRound)) {
                System.out.println("----------------------------------------------------------------------------------------------");
                System.out.println("Fin de la partie !\n");
                for (int j = 0; j < PLAYER_COUNT; j++) {
                    System.out.println("Main de " + game.getPlayers().get(j) +  " : " + game.getPlayerHand(game.getPlayers().get(j)).toString());
                }
                System.out.println("StockPile : " + game.getStockPile());
                System.out.println("\n" + firstPlayerInRound + " a gagné.\n");
                firstPlayerInRound = players.poll();
            }
        }        
    }
}
