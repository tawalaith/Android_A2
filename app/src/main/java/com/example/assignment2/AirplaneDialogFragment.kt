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

class AirplaneDialogFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_airplane_dialog, container, false)
        return rootView;
    }

    override fun onViewCreated(rootView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(rootView, savedInstanceState)

       val btnSubmit = rootView.findViewById<Button>(R.id.submitAirplaneBtn)
        val btnCancel = rootView.findViewById<Button>(R.id.cancelAirplaneBtn)
        val radioGroup = rootView.findViewById<RadioGroup>(R.id.airplaneRadioGroup)
        val imageResultView = rootView.findViewById<TextView>(R.id.imageView);

        btnSubmit.setOnClickListener {
            val currentID: Int = radioGroup.checkedRadioButtonId
            val currentlySelected = rootView.findViewById<RadioButton>(currentID)
            val selectedAirplane = currentlySelected.text.toString().lowercase();
            var retID: Int = R.drawable.ic_launcher_foreground;

            if(selectedAirplane.contains("airbus"))
                retID = R.drawable.airbus;
            if(selectedAirplane.contains("boeing"))
                retID = R.drawable.boeing;
            if(selectedAirplane.contains("embraer"))
                retID = R.drawable.embraer;

            val m1:MainActivity = getActivity() as MainActivity
            m1.changeImageTo(retID)
            dismiss();
        }

        btnCancel.setOnClickListener {
            dismiss();
        }
    }

}