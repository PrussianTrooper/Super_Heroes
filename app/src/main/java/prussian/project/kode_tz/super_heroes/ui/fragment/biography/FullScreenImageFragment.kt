package prussian.project.kode_tz.super_heroes.ui.fragment.biography

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

class FullScreenImageFragment : Fragment() {

    private lateinit var imageView : ImageView
    private val args: FullScreenImageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /*   картинка на полный экран   */
        imageView = ImageView(context)
        return imageView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*   выбор картинки/ set image   */
        Glide.with(this)
            .load(args.image.image)
            .into(imageView)
    }
}