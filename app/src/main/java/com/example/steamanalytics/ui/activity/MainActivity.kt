package com.example.steamanalytics.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.steamanalytics.ui.navigation.NavGraph
import com.example.steamanalytics.ui.theme.AppTheme
import com.example.steamanalytics.viewmodels.InventoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   private val inventoryViewModel: InventoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                NavGraph(inventoryViewModel, applicationContext)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    AppTheme {
    }
}