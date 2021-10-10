package ar.com.mitch.composeforbeginners.app.presentation.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ar.com.mitch.composeforbeginners.app.util.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
           setContent {
               val result = viewModel.recipes.value

               for (recipe in result) {
                   Log.d(TAG, "onCreateView: ${recipe.title}")
               }

               Column(modifier = Modifier.padding(16.dp)) {
                   Text(
                       text = "Recipe List",
                       style = TextStyle(fontSize = 21.sp)
                   )
                   Spacer(modifier = Modifier.padding(12.dp))
                   Button(
                       onClick = {
                           viewModel.newSearch()
                       }
                   ) {
                       Text(text = "PERFORM SEARCH")
                   }
               }
           }
        }

    }
}