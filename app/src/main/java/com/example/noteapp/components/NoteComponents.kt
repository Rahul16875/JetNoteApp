package com.example.noteapp.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(
    modifier: Modifier=Modifier,
    text: String,
    label: String,
    maxLines: Int = 1,
//    enabled: Boolean,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
                  ){

            val keyboardController = LocalSoftwareKeyboardController.current

            TextField(
                value = text,
                onValueChange = onTextChange,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                ),
//                enabled = enabled,
                maxLines = maxLines,
                label = { Text(text = label)},
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    onImeAction()
                    keyboardController?.hide()
                }),
                modifier = Modifier

                )
}

@Composable
fun NoteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
){
    Button(onClick =  onClick,
            shape = CircleShape,
        enabled = enabled,
        modifier = Modifier
        ) {
            Text(text = text)
    }
}