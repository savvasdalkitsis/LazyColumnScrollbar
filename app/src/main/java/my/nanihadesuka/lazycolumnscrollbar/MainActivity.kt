package my.nanihadesuka.lazycolumnscrollbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.nanihadesuka.compose.LazyColumnScrollbar
import my.nanihadesuka.lazycolumnscrollbar.ui.theme.LazyColumnScrollbarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainView() }
    }
}

@Preview(showBackground = true)
@Composable
fun MainView() {
    LazyColumnScrollbarTheme {
        Surface(color = MaterialTheme.colors.background) {
            ListView()
        }
    }
}

@Composable
fun ListView() {
    val listData = (0..1000).toList()
    val listState = rememberLazyListState()

    LazyColumnScrollbar(listState) {
        LazyColumn(state = listState) {
            items(listData) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                )
            }
        }
    }
}
