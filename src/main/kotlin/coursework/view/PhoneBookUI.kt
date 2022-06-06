package coursework.view

import coursework.contacts.contact.PhoneBook
import coursework.model.Model
import coursework.savereadfile.WorkWithFile
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Container
import java.awt.Dimension
import javax.swing.*

private const val GAP = 10

class PhoneBookUI(listContacts: List<PhoneBook> = listOf()) : JFrame("Phone book") {
    private var dataModel: Model = Model(listContacts)
    private val statusLabel = JLabel("Phone book", JLabel.CENTER)
    private val listChoice = DefaultListModel<String>()
    private var buttons = JList(listChoice)
    private var menuPanel = createScroll()
    private val listText = mutableListOf<JTextField>()

    init {
        updateFont(statusLabel, 23.0f)

        buttons.selectionMode = ListSelectionModel.SINGLE_SELECTION
        buttons.prototypeCellValue = "Кононов Александр Александрович"
        minimumSize = Dimension(1200, 900)
        defaultCloseOperation = EXIT_ON_CLOSE
        rootPane.contentPane = createMenuPanel() as Container?
    }

    private fun createMenuPanel(): Component {
        val panel = JPanel(BorderLayout(GAP, GAP)).apply {
            add(statusLabel, BorderLayout.NORTH)
            add(menuPanel, BorderLayout.WEST)
            add(createButtonsTransformation(), BorderLayout.SOUTH)
            border = BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP)
        }
        return panel
    }

    private fun createButtonsTransformation(): Component {
        val panel = JPanel().apply {
            add(createCreateButton())
            add(createRefactorButton())
            add(createDeleteButton())
            add(createSaveButton())
        }
        return panel
    }

    private fun createRefactorButton(): JButton {
        val refactorButton = JButton("Редактировать")
        updateFont(refactorButton, 20.0f)
        refactorButton.addActionListener {
            if (buttons.selectedIndex != -1) {
                rootPane.contentPane.add(createCreateRefactorPanel(true), BorderLayout.CENTER)
                rootPane.contentPane.remove(2)
                rootPane.contentPane.add(createButtonsRefactor(true, buttons.selectedIndex), BorderLayout.SOUTH)
                rootPane.repaint()
                rootPane.revalidate()
            }
        }
        return refactorButton
    }

    private fun createCreateButton(): JButton {
        val createButton = JButton("Создать")
        updateFont(createButton, 20.0f)
        createButton.addActionListener {
            rootPane.contentPane.add(createCreateRefactorPanel(false), BorderLayout.CENTER)
            rootPane.contentPane.remove(2)
            rootPane.contentPane.add(createButtonsRefactor(false, buttons.selectedIndex), BorderLayout.SOUTH)
            rootPane.repaint()
            rootPane.revalidate()
        }
        return createButton
    }

    private fun createDeleteButton(): Component {
        val removeButton = JButton("Удалить")
        updateFont(removeButton, 20.0f)
        removeButton.addActionListener {
            if (buttons.selectedIndex != -1) {
                val index = buttons.selectedIndex
                deleteProfile(index)
            }
        }

        return removeButton
    }

    private fun createScroll(): JScrollPane {
        for (contact in dataModel.contacts)
            listChoice.add(listChoice.size(), contact.getName().toString())
        buttons = JList(listChoice)
        return JScrollPane(buttons)
    }

    private fun createCreateRefactorPanel(isRefactor: Boolean): Component {
        val contact = if (isRefactor) dataModel.contacts[buttons.selectedIndex]
        else PhoneBook()
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
        val panel = JPanel().apply {
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
        return JScrollPane(panel)
    }

    private fun createButtonsRefactor(isRefactor: Boolean, index: Int): Component {
        val panel = JPanel().apply {
            add(createRefactorSaveButton(isRefactor, index))
            add(createButtonBack())
        }
        return panel
    }

    private fun deleteProfile(index: Int) {
        dataModel.removeProfile(index)
        listChoice.remove(index)
        menuPanel.repaint()
        menuPanel.revalidate()
    }

    private fun createRefactorSaveButton(isRefactor: Boolean, index: Int): JButton {
        val but = JButton()
        if (isRefactor) {
            but.text = "Редактировать"
            but.addActionListener {
                refactorContact(index)
            }
        } else {
            but.text = "Создать"
            but.addActionListener {
                createContact()
            }
        }
        updateFont(but, 20.0f)
        return but
    }

    private fun createContact() {
        refactorCreateContact(false)
        listChoice.add(listChoice.size(), dataModel.contacts[dataModel.contacts.size - 1].getName().toString())
    }

    private fun refactorContact(index: Int) {
        refactorCreateContact(true, index)
        listChoice[index] = dataModel.contacts[index].getName().toString()
    }

    private fun refactorCreateContact(isRefactor: Boolean, index: Int = buttons.selectedIndex) {
        if (listText[0].text == "" || listText[1].text == "" || listText[2].text == "") {
            JOptionPane.showConfirmDialog(
                this,
                "Имя, фамилия и отчество не должны быть пустыми!!",
                "Неверный ввод",
                JOptionPane.OK_OPTION
            )
        } else {
            val contact = PhoneBook()
            contact.changeName(listText[0].text, listText[1].text, listText[2].text)
            contact.changeDate(listText[3].text.toInt(), listText[4].text.toInt(), listText[5].text.toInt())
            contact.changeAddress(listText[6].text, listText[7].text, listText[8].text, listText[9].text)
            val emails = listText[10].text.split(",").toMutableList()
            if (emails.last() == "")
                emails.removeAt(emails.lastIndex)
            if (isRefactor)
                dataModel.contacts[index].removeAllEmails()
            contact.addEmails(emails)
            val numbers = listText[11].text.split(",").toMutableList()
            if (numbers.last() == "")
                numbers.removeAt(numbers.lastIndex)
            if (isRefactor)
                dataModel.contacts[index].removeAllNumbers()
            contact.addNumbers(numbers)
            if (isRefactor)
                dataModel.changeContact(index, contact)
            else
                dataModel.addContact(contact)
            back()
        }
    }

    private fun createButtonBack(): JButton {
        val but = JButton("Назад")
        but.addActionListener {
            back()
        }
        updateFont(but, 20.0f)
        return but
    }

    private fun back() {
        listText.clear()
        rootPane.contentPane = createMenuPanel() as Container?
        rootPane.repaint()
        rootPane.revalidate()
    }

    private fun updateFont(component: JComponent, newFontSize: Float) {
        val font = component.font
        val derivedFont = font.deriveFont(newFontSize)
        component.font = derivedFont
    }

    private fun createSaveButton(): JButton {
        val saveButton = JButton("Сохранить")
        updateFont(saveButton, 20.0f)
        saveButton.addActionListener {
            save()
        }
        return saveButton
    }

    private fun save() {
        val file = WorkWithFile()
        file.writeToFile(dataModel.contacts)
    }
}