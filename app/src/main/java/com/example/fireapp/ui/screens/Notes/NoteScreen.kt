import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NoteScreen() {
    var newNote by remember { mutableStateOf(TextFieldValue()) }
    var notes by remember { mutableStateOf(mutableListOf<String>()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            NoteTextField(
                value = newNote,
                onValueChange = { newNote = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            AddButton(onClick = {
                if (newNote.text.isNotBlank()) {
                    notes.add(newNote.text)
                    newNote = TextFieldValue()
                }
            })
        }

        Spacer(modifier = Modifier.height(16.dp))

        NotesList(notes = notes)
    }
}

@Composable
fun NoteTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Add a new note") }
    )
}

@Composable
fun AddButton(onClick: () -> Unit) {
    Button(
        onClick = onClick
    ) {
        Text("Add")
    }
}

@Composable
fun NotesList(notes: List<String>) {
    Column {
        notes.forEach { note ->
            Text(
                text = "- $note",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNoteScreen() {
    MaterialTheme {
        Surface {
            NoteScreen()
        }
    }
}