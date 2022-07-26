# DotLoaderButton
Android Button which show loading three dots with animation

# Add DotLoaderButton in your app level Gradle

implementation 'com.github.emmessess:DotLoaderButton:0.1.4'

# In XML File add button as

 <com.emmessess.loaderbutton.DotLoaderButton
            android:id="@+id/buttonLogin"
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:layout_below="@id/llAlreadyHaveAccount"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="20dp"
            android:alpha=".5"
            android:clickable="true"
            android:fontFamily="@font/nunito_semibold"
            android:paddingTop="10dp"
            android:paddingBottom="10dp"
            android:textAllCaps="false"
            android:textColor="@color/white"
            android:textSize="15sp"
            app:disabledBackground="@drawable/button_unselected_bg"
            app:enabledBackground="@drawable/button_selected_bg"
            app:title="Next" />
            
# In Activity or Fragment

Declare Variabe 

lateinit var buttonLogin: DotLoaderButton

Initialize

buttonLogin = view.findViewById(R.id.buttonLogin)

Show Loader
buttonLogin.showLoading()

Hide Loader
buttonLogin.hideLoading()


