package com.example.foodadmin.ui.AddRestaurant;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodadmin.LoginActivity;
import com.example.foodadmin.MainActivity;
import com.example.foodadmin.R;
import com.example.foodadmin.model.MenuItem;
import com.example.foodadmin.model.Restaurant;
import com.example.foodadmin.ui.home.HomeFragment;
import com.example.foodadmin.ui.home.HomeViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class addRestaurantFragment extends Fragment {
   Button addButton;

    public addRestaurantFragment() {
    }

    TextView restaurantName,Description,ImageURl,Location;
   private AddRestaurantModel addRestaurantModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addRestaurantModel =
                new ViewModelProvider(this).get(AddRestaurantModel.class);
        View root = inflater.inflate(R.layout.fragment_add_restaurant, container, false);
        addButton = root.findViewById(R.id.addRestaurantID);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantName=root.findViewById(R.id.restaurantNameid);
                Description = root.findViewById(R.id.descriptionID);
                ImageURl = root.findViewById(R.id.imgURLID);
                Location = root.findViewById(R.id.locationID);
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                CollectionReference reference = db.collection("Restaurants");
                Restaurant myRestaurant = new Restaurant();
                myRestaurant.setRestaurantName(restaurantName.getText().toString());
                myRestaurant.setRestaurantDescription(Description.getText().toString());
                myRestaurant.setRestaurantLocation(Location.getText().toString());
                myRestaurant.setRestaurantImgUrl(ImageURl.getText().toString());
                restaurantName.setText("");
                Description.setText("");
                ImageURl.setText("");
                Location.setText("");
                List<MenuItem> myMenus = new ArrayList<>();
                for(int i=0;i<1;i++){
                    myMenus.add(new MenuItem("Mutton Kacchi","Khub e test",399));

              }
                myRestaurant.setRestaurantMenuList(myMenus);
                reference.add(myRestaurant).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if(task.isSuccessful()){

                        }else{

                        }
                    }
                });

//                HomeFragment homeFragment = new HomeFragment();
//                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                transaction.replace(R.id.restaurantNameIDLayout,homeFragment);
//                transaction.commit();

            }
        });

        addRestaurantModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;

    }


}