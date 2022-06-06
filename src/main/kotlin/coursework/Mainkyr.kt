package coursework

import coursework.savereadfile.WorkWithFile
import coursework.view.PhoneBookUI
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        val ticTacToeUi = PhoneBookUI(WorkWithFile().getListContacts())
        ticTacToeUi.isVisible = true
    }
}