/*
 * Copyright (C) 2015 nuno
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package teste;

import java.util.EmptyStackException;
import java.util.Scanner;
import model.Game;

/**
 *
 * @author nuno
 */
public class ConsoleTest {

    public static final Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Game m = new Game();
        System.out.println("-------------GAME-------------");
        System.out.println("\n\nGOLD: move all dics from rod 1 to to ROD 3!");
        System.out.println(m.gameToString());
        int opcao;
        int opcao1;
        do {
            System.out.print("Move disc from rod:");
            opcao = in.nextInt();
            
            System.out.print("to rod:");
            opcao1 = in.nextInt();
            try {
                m.moveDisk(opcao, opcao1);
                m.incrementPlaysNumber();
            } catch (Error ex) {
                System.out.println(ex.getMessage() + "\nPress ENTER to continue");
                in.nextLine();
                in.nextLine();
            } catch (EmptyStackException ex) {
                System.out.println("Rod selected, contains no disk!\nPress ENTER to continue");
                in.nextLine();
                in.nextLine();
            } catch (IndexOutOfBoundsException ex){
                System.out.println("Rod selected does not exist.\nPress ENTER to continue");
                in.nextLine();
                in.nextLine();
            }
            System.out.println(m.gameToString());

        } while (m.wonVerify() != true);
        
        System.out.println("Congratulations! Has won.");

    }

}
