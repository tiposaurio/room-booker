package layout;

import android.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.tim11.pma.ftn.pmaprojekat.MainActivity;
import com.tim11.pma.ftn.pmaprojekat.R;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;
import com.tim11.pma.ftn.pmaprojekat.dto.SearchViewModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EFragment(R.layout.fragment_filter)
public class FilterFragment extends Fragment {

    @Bean
    HotelService hotelService;

    @ViewById
    Button tbStars1;

    @ViewById
    Button tbStars2;

    @ViewById
    Button tbStars3;

    @ViewById
    Button tbStars4;

    @ViewById
    Button tbStars5;

    @ViewById
    Button btnSearch;

    @ViewById
    TextView tvMinRating;

    @ViewById
    EditText etHotelName;

    @ViewById
    SeekBar sbMinRating;

    @ViewById
    TextView tvMaxRoomPrice;

    @ViewById
    SeekBar sbMaxRoomPrice;


    @AfterViews
    public void init(){
        sbMinRating.incrementProgressBy(1);

        tvMinRating.setText(String.valueOf( (double)sbMinRating.getProgress() / 10));
        sbMinRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double dProgress = (double) progress / 10;
                tvMinRating.setText(String.valueOf(dProgress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbMaxRoomPrice.incrementProgressBy(10);

        tvMaxRoomPrice.setText(String.valueOf( sbMaxRoomPrice.getProgress()));
        sbMaxRoomPrice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int newProgress = (progress / 10) * 10;

                sbMaxRoomPrice.setProgress(newProgress);
                tvMaxRoomPrice.setText(String.valueOf(newProgress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @Click
    public void btnSearch(){

        List<Integer> stars = new ArrayList<Integer>();
        if(tbStars1.getText().toString().equals("ON")) stars.add(1);
        if(tbStars2.getText().toString().equals("ON")) stars.add(2);
        if(tbStars3.getText().toString().equals("ON")) stars.add(3);
        if(tbStars4.getText().toString().equals("ON")) stars.add(4);
        if(tbStars5.getText().toString().equals("ON")) stars.add(5);

        if(stars.isEmpty()){
            stars.addAll(Arrays.asList( new Integer[] {1, 2, 3, 4, 5}));
        }

        SearchViewModel searchViewModel = new SearchViewModel(stars,
                Double.parseDouble(tvMinRating.getText().toString()),
                Double.parseDouble(tvMaxRoomPrice.getText().toString()),
                etHotelName.getText().toString() );
        findHotels(searchViewModel);
    }


    @Background
    public void findHotels(SearchViewModel searchViewModel){

        try {
            List<Hotel> result = hotelService.search(searchViewModel);
            MainActivity mainActivity = (MainActivity)getActivity();

            ArrayList<Hotel> alResult = new ArrayList<Hotel>(result);
            mainActivity.setHotelList(alResult);
            mainActivity.changeFragment(HotelListFragment_.builder().build());

        }catch(RestClientException e){

        }
    }

}
