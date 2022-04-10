//Jairam Kakar - N01179234 - CENG-258-RNC
//Aryan Sood - N01393003 - CENG-258-RNA

package aryan1.jairam2.codemasters.ui.shape;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import aryan1.jairam2.codemasters.R;

public class ShapeFrag extends Fragment {

    View root;
    public static ShapeFrag newInstance() {
        return new ShapeFrag();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

       root=inflater.inflate(R.layout.shape_fragment, container, false);

        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textView = root.findViewById(R.id.jairamAryanAutoCompleteTV);
// Get the string array
        String[] emails = getResources().getStringArray(R.array.emails);
// Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, emails);
        textView.setAdapter(adapter);
        RadioGroup radioGroup = root.findViewById(R.id.jairamAryanShapeRG);
       radioGroup.setOnCheckedChangeListener((radioGroup1, i) -> shapes());// Checking to see which radio button is checked

        return root;
    }

    private void setShapeByDrawable(Drawable drawable) {
        //image view to display the shape
        ImageView reusableImageView = root.findViewById(R.id.jairamAryanShapesIV);
        reusableImageView.setImageDrawable(drawable);
    }
    private void shapes() {
        //Radio buttons to find out which shape is selected
        RadioButton oval = root.findViewById(R.id.jairamAryanOvalRB);
        RadioButton arch = root.findViewById(R.id.jairamAryanArchRB);
        RadioButton rec = root.findViewById(R.id.jairamAryanRectangleRB);
        RadioButton star= root.findViewById(R.id.jairamAryanStarRB);
        if(oval.isChecked())//Showing Oval
        {
            ShapeDrawable d = new ShapeDrawable(new OvalShape());
            d.setIntrinsicHeight(350);
            d.setIntrinsicWidth(350);
            d.getPaint().setColor(Color.MAGENTA);
            setShapeByDrawable(d);
        }

        else if(arch.isChecked())//Showing Arch
        {
            // Create a arc, pacman style
            ShapeDrawable d = new ShapeDrawable(new ArcShape(0, 325));
            d.setIntrinsicHeight(350);
            d.setIntrinsicWidth(350);
            d.getPaint().setColor(Color.MAGENTA);
            setShapeByDrawable(d);
        }

        else if(rec.isChecked())//Showing Round Rectangle
        {
            ShapeDrawable d = new ShapeDrawable(new RoundRectShape(
                    new float[] { 30, 30, 30, 30, 30, 30, 40, 40 }, null, null));
            d.setIntrinsicHeight(350);
            d.setIntrinsicWidth(350);
            d.getPaint().setColor(Color.MAGENTA);
            setShapeByDrawable(d);
        }
        else if (star.isChecked())//Showing Star
        {
            Path p = new Path(); // pretty star, filled
            p.moveTo(50, 0);
            p.lineTo(25,100);
            p.lineTo(100,50);
            p.lineTo(0,50);
            p.lineTo(100,100);
            p.lineTo(50,0);
            //
            ShapeDrawable d = new ShapeDrawable(new PathShape(p, 100, 100));
            d.setIntrinsicHeight(350);
            d.setIntrinsicWidth(350);
            d.getPaint().setColor(Color.MAGENTA);
            setShapeByDrawable(d);
        }
    }


}