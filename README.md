# DotLoaderButton
Android Button which show loading three dots with animation

# Add DotLoaderButton in your app level Gradle

implementation 'com.github.emmessess:DotLoaderButton:0.1.4'

# In XML File add button as

 <com.emmessess.loaderbutton.DotLoaderButton<br />
            android:id="@+id/buttonLogin"<br />
            android:layout_width="match_parent"<br />
            android:layout_height="50dp"<br />
            android:layout_below="@id/llAlreadyHaveAccount"<br />
            android:layout_centerHorizontal="true"<br />
            android:layout_marginTop="20dp"<br />
            android:alpha=".5"<br />
            android:clickable="true"<br />
            android:fontFamily="@font/nunito_semibold"<br />
            android:paddingTop="10dp"<br />
            android:paddingBottom="10dp"<br />
            android:textAllCaps="false"<br />
            android:textColor="@color/white"<br />
            android:textSize="15sp"<br />
            app:disabledBackground="@drawable/button_unselected_bg"<br />
            app:enabledBackground="@drawable/button_selected_bg"<br />
            app:title="Login" /><br />
            
# In Activity or Fragment

Declare Variabe <br />

lateinit var buttonLogin: DotLoaderButton <br />

Initialize<br />

buttonLogin = view.findViewById(R.id.buttonLogin)<br />

Show Loader<br />
buttonLogin.showLoading()<br />

Hide Loader<br />
buttonLogin.hideLoading()


