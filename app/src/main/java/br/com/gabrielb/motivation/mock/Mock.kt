package br.com.gabrielb.motivation.mock

import br.com.gabrielb.motivation.util.MotivationConstants
import java.util.*

class Phrase(val description:String, val category:Int)

class Mock {
    private val ALL = MotivationConstants.PHRASE_FILTER.ALL
    private val SUN = MotivationConstants.PHRASE_FILTER.SUN
    private val HAPPY = MotivationConstants.PHRASE_FILTER.HAPPY

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas.", HAPPY),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso", SUN),
        Phrase("Se você acredita, faz toda a diferença", SUN)
    )


    fun getPhrase(value:Int):String{

        val filtered = mListPhrases.filter { it.category == value || value == ALL }

        val rand = Random().nextInt(filtered.size)

        return filtered[rand].description

    }
}