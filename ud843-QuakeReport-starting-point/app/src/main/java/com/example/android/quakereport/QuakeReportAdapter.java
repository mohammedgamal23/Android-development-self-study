package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class QuakeReportAdapter extends ArrayAdapter<QuakeReport> {
    public QuakeReportAdapter( Context context, int resource, ArrayList<QuakeReport> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View listitemview = convertView;
        if(listitemview == null)
        {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.custom_list,parent,false);
        }
        QuakeReport quakeReport = getItem(position);
        TextView tv = (TextView) listitemview.findViewById(R.id.txtViewScale);
        String formattedMagnitude = formatMagnitude(quakeReport.getScale());
        tv.setText(formattedMagnitude);
        TextView tv1 = (TextView) listitemview.findViewById(R.id.txtViewPlace);
        tv1.setText(quakeReport.getCity());
        TextView tv2 = (TextView) listitemview.findViewById(R.id.txtViewDate);
        tv2.setText(quakeReport.getTime());
        TextView tv3 = (TextView) listitemview.findViewById(R.id.txtViewOffset);
        tv3.setText(quakeReport.getOffset());

        GradientDrawable magnitudeCircle = (GradientDrawable) tv.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(quakeReport.getScale());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listitemview;
    }

    private int getMagnitudeColor(double scale) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(scale);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatMagnitude(double scale) {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(scale);
    }
}
