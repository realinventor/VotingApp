package co.nexus.votingapp.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import co.nexus.votingapp.R;
import co.nexus.votingapp.Student.StudentHome;
import co.nexus.votingapp.Teacher.TeacherHome;

public class SignInActivity extends AppCompatActivity {
    private TextInputEditText emailInputSignIn, passwordInputSignIn;
    private Button buttonSignIn;
    private String TAG = "SignInActivity";
    private TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        emailInputSignIn = findViewById(R.id.emailInputSignIN);
        passwordInputSignIn = findViewById(R.id.passwordInputSignIn);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        signUpTextView = findViewById(R.id.signUpTextView);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signInWithEmailAndPassword(emailInputSignIn.getText().toString(), passwordInputSignIn.getText().toString())
                        .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
//                                    updateUI(user);

                                    if(user.getDisplayName().equals("student")){
                                        startActivity(new Intent(SignInActivity.this, StudentHome.class));
                                    }
                                    else{
                                        startActivity(new Intent(SignInActivity.this, TeacherHome.class));
                                    }
                                    finish();


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignInActivity.this, task.getException().getMessage(),
                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);

                                }
                            }
                        });
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Sign Up Button Clicked!");
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
                finish();
            }
        });


    }
}
