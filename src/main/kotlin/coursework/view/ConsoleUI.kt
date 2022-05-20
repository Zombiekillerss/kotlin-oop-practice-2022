package coursework.view

import coursework.model.Model
import coursework.model.ModelChangeListener

class ConsoleUi(private val model: Model) {
    init {
        val listener = object : ModelChangeListener {
            override fun onModelChanged() {
                repaint()
            }
        }
        model.addModelChangeListener(listener)

        repaint()
    }

    private fun repaint() {
        println(model)
    }
}