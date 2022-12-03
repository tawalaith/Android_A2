import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.assignment2.MainActivity
import com.example.assignment2.R

class CarDialogFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_car_dialog, container, false)
        return rootView;
    }

    override fun onViewCreated(rootView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(rootView, savedInstanceState)

        val btnSubmit = rootView.findViewById<Button>(R.id.submitCarBtn)
        val btnCancel = rootView.findViewById<Button>(R.id.cancelCarBtn)
        val radioGroup = rootView.findViewById<RadioGroup>(R.id.carRadioGroup)
        val resultView = rootView.findViewById<TextView>(R.id.imageView);

        btnSubmit.setOnClickListener {
            val currentID: Int = radioGroup.checkedRadioButtonId
            val currentlySelected = rootView.findViewById<RadioButton>(currentID)
            val selectedCar = currentlySelected.text.toString().lowercase();
            var retID: Int = R.drawable.ic_launcher_foreground;

            if(selectedCar.contains("ferrari"))
                retID = R.drawable.ferrari;
            if(selectedCar.contains("lamborghini"))
                retID = R.drawable.lambo;
            if(selectedCar.contains("bugatti"))
                retID = R.drawable.bugatti;

            val m1:MainActivity = getActivity() as MainActivity
            m1.changeImageTo(retID)
            dismiss();
        }

        btnCancel.setOnClickListener {
            dismiss();
        }
    }

}