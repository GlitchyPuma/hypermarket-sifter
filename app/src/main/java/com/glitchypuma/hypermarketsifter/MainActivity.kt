package com.glitchypuma.hypermarketsifter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var fab: FloatingActionButton
    lateinit var newPhotoButton: ExtendedFloatingActionButton
    lateinit var openPhotosButton: ExtendedFloatingActionButton
    lateinit var inputManuallyButton: ExtendedFloatingActionButton
    var newInputMenuHidden: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        fab = findViewById(R.id.floating_action_button)
        newPhotoButton = findViewById(R.id.new_photo_button)
        openPhotosButton = findViewById(R.id.open_photos_button)
        inputManuallyButton = findViewById(R.id.input_manually_button)

        fab.setOnClickListener(){
            if(newInputMenuHidden){
                newPhotoButton.show()
                openPhotosButton.show()
                inputManuallyButton.show()
                newInputMenuHidden = false
            } else {
                newPhotoButton.hide()
                openPhotosButton.hide()
                inputManuallyButton.hide()
                newInputMenuHidden = true
            }
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.topbar_menu, menu)
        return true
    }
}