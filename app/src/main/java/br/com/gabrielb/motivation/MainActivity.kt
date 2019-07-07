package br.com.gabrielb.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gabrielb.motivation.util.MotivationConstants
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import br.com.gabrielb.motivation.mock.Mock
import br.com.gabrielb.motivation.util.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter: Int = MotivationConstants.PHRASE_FILTER.ALL
    private lateinit var mSecurityPreferences: SecurityPreferences
    private val mMock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)

        setListeners()

        handleFilter(R.id.imageAll)
        refreshPhrase()
        verifyUserName()

        }

    override fun onClick(view: View) {
        val id = view.id
        val listId = listOf(R.id.imageAll, R.id.sun, R.id.happy)
        if (id in listId){
            handleFilter(id)
        }else if (id == R.id.buttonNewPhrase){
            refreshPhrase()
        }

    }

    private fun setListeners(){
        imageAll.setOnClickListener(this)
        sun.setOnClickListener(this)
        happy.setOnClickListener(this)
        buttonNewPhrase.setOnClickListener(this)
    }

    private fun verifyUserName(){
        textUserName.text = mSecurityPreferences.getStoredString("key")
    }


    private fun handleFilter(id:Int){
        if(id==R.id.imageAll){
            mFilter
            imageAll.setImageResource(R.drawable.ic_all_selected)
            sun.setImageResource(R.drawable.ic_sun_uselected)
            happy.setImageResource(R.drawable.ic_happy_unselected)
        }else if(id == R.id.sun){
            mFilter = MotivationConstants.PHRASE_FILTER.SUN
            imageAll.setImageResource(R.drawable.ic_all_unselected)
            sun.setImageResource(R.drawable.ic_sun_selected)
            happy.setImageResource(R.drawable.ic_happy_unselected)
        }else{
            mFilter = MotivationConstants.PHRASE_FILTER.HAPPY
            imageAll.setImageResource(R.drawable.ic_all_unselected)
            sun.setImageResource(R.drawable.ic_sun_uselected)
            happy.setImageResource(R.drawable.ic_happy_selected)
        }
    }

    private fun refreshPhrase(){
        textPhrase.text = mMock.getPhrase(mFilter)

    }

}

