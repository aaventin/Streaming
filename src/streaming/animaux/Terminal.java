/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.animaux;

/**
 *
 * @author admin
 */
public class Terminal {

    private static Terminal singleton = null;

    public static Terminal creation() {
        if (singleton == null) {
            singleton = new Terminal();

            return singleton;

        } else { return singleton;

        }

    }

    private Terminal() {

    }

}
