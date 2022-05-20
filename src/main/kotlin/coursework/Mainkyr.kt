package coursework

import coursework.view.ChessUI
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        val ticTacToeUi = ChessUI()
        ticTacToeUi.isVisible = true
    }
}