package com.example.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        UserDTO testUser = new UserDTO();
        testUser.setName("Andreas");
        testUser.setEmail("Test2@Test");
        DatabaseReference userRef = myRef.child(testUser.getEmail());
        userRef.setValue(testUser);
        String email = "Test@Test";
        DatabaseReference getRef = myRef.child(email);
*/

/*
        IngredientDTO testIngredient = new IngredientDTO("3", "Toastbrød");
        DatabaseReference ingreRef = myRef.child("ingredients").child(testIngredient.getID());
        ingreRef.setValue(testIngredient);
*/

/*
        UnitDTO testUnit = new UnitDTO("Styk");
        DatabaseReference unitRef = myRef.child("units").child(testUnit.getUnitType());
        unitRef.setValue(testUnit);
*/



        ArrayList<String> ingredientList = new ArrayList<>();
        ingredientList.add("3");
        ingredientList.add("4");
        ingredientList.add("5");

        ArrayList<String> steps = new ArrayList<>();
        steps.add("Læg en skive ost på en skive brød");
        steps.add("Læg en skive skinke oven på osten");
        steps.add("Læg en skive ost oven på skinken");
        steps.add("Læg en skive brød oven på skinken");
        steps.add("Varm toasten i en toaster i 3 min");

        ArrayList<UnitDTO> unitList = new ArrayList<>();
        UnitDTO testUnit = new UnitDTO("Styk");
        unitList.add(testUnit);
        unitList.add(testUnit);
        unitList.add(testUnit);

        ArrayList<Integer> unitAmount = new ArrayList<>();
        unitAmount.add(2);
        unitAmount.add(1);
        unitAmount.add(2);


        RecipieDTO testReci = new RecipieDTO("2", "Toast", 5, 1);
        testReci.setIngredientList(ingredientList);
        testReci.setSteps(steps);
        testReci.setUnitList(unitList);
        testReci.setUnitAmount(unitAmount);


        DatabaseReference reciRef = myRef.child("recipies").child(testReci.getID());
        reciRef.setValue(testReci);

        UserDTO testUser = new UserDTO("Andy", "Test@Test");
        DatabaseReference userRef = myRef.child("users").child(testUser.getEmail());
        testUser.getUploadedRecipies().add(testReci.getID());
        userRef.setValue(testUser);




                    // Read from the database
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            // This method is called once with the initial value and again
                            // whenever data at this location is updated.
                            //UserDTO value = dataSnapshot.getValue(UserDTO.class);
                /*
                for (DataSnapshot messageSnapshot: dataSnapshot.child("users").getChildren()){
                    if (messageSnapshot.getKey().equals("Test@Test")){
                        UserDTO post = messageSnapshot.getValue(UserDTO.class);
                        Log.d(TAG, "______________Value is: " + post.getName() + " " + post.getEmail());
                        break;
                    }
                }

                 */

                            for (DataSnapshot mss: dataSnapshot.child("recipies").getChildren()){
                                if (mss.getKey().equals("1")){
                                    RecipieDTO post = mss.getValue(RecipieDTO.class);
                                    String item = post.getIngredientList().get(2);
                                    for (DataSnapshot mss2: dataSnapshot.child("ingredients").getChildren()){
                                        if (mss2.getKey().equals(item)){
                                            IngredientDTO post2 = mss2.getValue(IngredientDTO.class);
                                            Log.d(TAG, "______________ " + post2.getName());
                                        }
                                    }
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            //Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });


        for (int i = 0; i < ingredientList.size(); i++){
            DatabaseReference ingreRef = myRef.child("ingredients").child(ingredientList.get(i));

            ArrayList<String> items = new ArrayList<>();



            items.add(testReci.getID());


            ingreRef.child("inRecipies").setValue(items);

        }


            }







}
