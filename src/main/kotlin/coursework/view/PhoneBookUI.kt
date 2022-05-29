package coursework.view

import coursework.model.Model
import coursework.state.State
import java.awt.BorderLayout
import java.awt.Component
import javax.swing.*

private const val GAP = 10
private var stateDelete = State.DELETE_PROFILE

class PhoneBookUI : JFrame("Phone book") {
    private var dataModel: Model = Model()
    private val statusLabel = JLabel("Phone book", JLabel.CENTER)
    private val buttons = mutableListOf<JRadioButton>()
    private val radioGroup = ButtonGroup()
    private var scrollPanel: JPanel = createProfilePanel()
    private val menuPanel = createScroll()

    init {
        setSize(900, 700)
        defaultCloseOperation = EXIT_ON_CLOSE

        rootPane.contentPane = JPanel(BorderLayout(GAP, GAP)).apply {
            add(createMenuPanel())
            /*add(statusLabel, BorderLayout.NORTH)
            add(mainPanel, BorderLayout.CENTER)
            add(createButtonsTransformation(), BorderLayout.SOUTH)*/
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }
    }

    private fun createMenuPanel(): Component{
        val panel = JPanel(BorderLayout(GAP, GAP)).apply {
            add(statusLabel, BorderLayout.NORTH)
            add(menuPanel, BorderLayout.CENTER)
            add(createButtonsTransformation(), BorderLayout.SOUTH)
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }

        return panel
    }

    private fun createButtonsTransformation(): Component {
        val panel = JPanel().apply {
            add(JButton("Создать"))
            add(JButton("Редактировать"))
            add(createDeleteButton())
            add(JButton("Сохранить"))
        }
        return panel
    }

    private fun createDeleteButton(): Component {
        val removeButton = JButton("Удалить")
        updateFont(removeButton, 20.0f)
        removeButton.addActionListener {
            val index: Int
            when (stateDelete) {
                State.DELETE_PROFILE -> {
                    if (buttons.filter { it.isSelected } != listOf<JRadioButton>())
                        if (buttons.indexOf(buttons.filter { it.isSelected }[0]) >= 0) {
                            index = buttons.indexOf(buttons.filter { it.isSelected }[0])
                            deleteProfile(index)
                        }
                }
                else ->
                    TODO()
            }
        }

        return removeButton
    }


    private fun createScroll(): JScrollPane {
        return JScrollPane(scrollPanel)
    }

    private fun createProfilePanel(): JPanel {
        var radioButton: JRadioButton
        for (contact in dataModel.contacts) {
            radioButton = JRadioButton((contact.getName().toString()))
            buttons.add(radioButton)
            radioGroup.add(radioButton)
        }

        val gamePanel = JPanel().apply {
            for (i in buttons)
                add(i)
        }
        gamePanel.layout = BoxLayout(gamePanel, BoxLayout.PAGE_AXIS)
        scrollPanel = gamePanel
        return gamePanel
    }

    private fun createCreateRefactorPanel() {

    }

    private fun deleteProfile(index: Int) {
        radioGroup.remove(buttons[index])
        dataModel.removeProfile(index)
        scrollPanel.remove(buttons[index])
        buttons.removeAt(index)
        menuPanel.repaint()
        menuPanel.revalidate()
    }

    private fun updateFont(component: JComponent, newFontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFontSize)
        component.font = derivedFont
    }
}