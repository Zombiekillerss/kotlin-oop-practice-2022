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
    private val listText = mutableListOf<JTextField>()

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
            add(createRefactorButton())
            add(createDeleteButton())
            add(JButton("Сохранить"))
        }
        return panel
    }

    private fun createRefactorButton(): JButton {
        val refactorButton = JButton("Редактировать")
        refactorButton.addActionListener {
            if(buttons.filter { it.isSelected } != listOf<JRadioButton>()){
                rootPane.contentPane.remove(0)
                rootPane.contentPane = JPanel(BorderLayout(GAP, GAP)).apply {
                    add(createRefactorMenu())
                    border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
                }
                rootPane.repaint()
                rootPane.revalidate()

            }
        }
        return refactorButton
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

    private fun createRefactorMenu(): Component{
        val menu = JPanel(BorderLayout(GAP, GAP)).apply{
            add(statusLabel, BorderLayout.NORTH)
            add(createCreateRefactorPanel(), BorderLayout.CENTER)
            add(createButtonsRefactor(true), BorderLayout.SOUTH)
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }
        return menu
    }

    private fun createCreateRefactorPanel(): Component {
        val contact = dataModel.contacts[buttons.indexOf(buttons.filter{it.isSelected}[0])]
        listText.add(JTextField(contact.getName().firstName))
        listText.add(JTextField(contact.getName().secondName))
        listText.add(JTextField(contact.getName().lastName))
        listText.add(JTextField(contact.getDate().day.toString()))
        listText.add(JTextField(contact.getDate().month.toString()))
        listText.add(JTextField(contact.getDate().year.toString()))
        listText.add(JTextField(contact.getAddresses().postcode))
        listText.add(JTextField(contact.getAddresses().city))
        listText.add(JTextField(contact.getAddresses().street))
        listText.add(JTextField(contact.getAddresses().houseNumber))
        listText.add(JTextField(contact.getEmails().toString()))
        listText.add(JTextField(contact.getNumbers().toString()))
        val panel = JPanel().apply{
            add(JLabel("Имя"))
            add(listText[0])
            add(JLabel("Фамилия"))
            add(listText[1])
            add(JLabel("Отчество"))
            add(listText[2])
            add(JLabel("Дата рождения"))
            add(JLabel("День"))
            add(listText[3])
            add(JLabel("Месяц"))
            add(listText[4])
            add(JLabel("Год"))
            add(listText[5])
            add(JLabel("Адрес"))
            add(JLabel("Индекс"))
            add(listText[6])
            add(JLabel("Город"))
            add(listText[7])
            add(JLabel("Улица"))
            add(listText[8])
            add(JLabel("Номер дома"))
            add(listText[9])
            add(JLabel("Emails"))
            add(listText[10])
            add(JLabel("Номера телефонов"))
            add(listText[11])
        }
        panel.layout = BoxLayout(panel, BoxLayout.PAGE_AXIS)
        return panel
    }

    private fun createButtonsRefactor(isRefactor: Boolean): Component{
        val panel = JPanel().apply {
            add(createRefactorSaveButton(isRefactor))
            add(createButtonBack())
        }
        return panel
    }

    private fun deleteProfile(index: Int) {
        radioGroup.remove(buttons[index])
        dataModel.removeProfile(index)
        scrollPanel.remove(buttons[index])
        buttons.removeAt(index)
        menuPanel.repaint()
        menuPanel.revalidate()
    }

    private fun createRefactorSaveButton(isRefactor: Boolean): JButton {
        val but = JButton()
        if(isRefactor){
            but.text = "Редактировать"
        }
        else {
            but.text = "Создать"
        }
        return but
    }

    private fun createButtonBack(): JButton {
        val but = JButton("Назад")
        but.addActionListener {
            rootPane.contentPane.remove(0)
            rootPane.contentPane = JPanel(BorderLayout(GAP, GAP)).apply {
                add(createMenuPanel())
                border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
            }
            rootPane.repaint()
            rootPane.revalidate()
        }
        return but
    }

    private fun updateFont(component: JComponent, newFontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFontSize)
        component.font = derivedFont
    }
}