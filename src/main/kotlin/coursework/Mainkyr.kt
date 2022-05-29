package coursework

import coursework.view.PhoneBookUI
import javax.swing.SwingUtilities

fun main() {
    SwingUtilities.invokeLater {
        val ticTacToeUi = PhoneBookUI()
        ticTacToeUi.isVisible = true
    }
}
/*import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

fun main(args: Array<String>) {

    val textArea = JTextArea()
    textArea.text = "Hello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\nHello, Kotlin/Swing world\n"
    val scrollPane = JScrollPane(textArea)

    val frame = JFrame("Hello, Kotlin/Swing")
    frame.contentPane.add(scrollPane, BorderLayout.CENTER)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.size = Dimension(600, 100)
    frame.setLocationRelativeTo(null)
    frame.isVisible = true

}*/