package ace.know.you.ado.morefragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add_fragment1;
    private Button btn_add_fragment2;
    private Button btn_remove_fragment1;
    private Button btn_replace_fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add_fragment1 =(Button)findViewById(R.id.btn_add_fragment1);
        btn_add_fragment1.setOnClickListener(this);

        btn_add_fragment2 =(Button)findViewById(R.id.btn_add_fragment2);
        btn_add_fragment2.setOnClickListener(this);

        btn_remove_fragment1 =(Button)findViewById(R.id.btn_remove_fragment1);
        btn_remove_fragment1.setOnClickListener(this);

        btn_replace_fragment2 =(Button) findViewById(R.id.btn_replace_fragment2);
        btn_replace_fragment2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_add_fragment1:
                Fragment fragment1 = new Fragment1();
                addFragment(R.id.fl_container,fragment1,"fragment1");
                break;
            case R.id.btn_add_fragment2:
                Fragment fragment2 = new Fragment2();
                addFragment(R.id.fl_container,fragment2,"fragment2");
                break;
            case R.id.btn_remove_fragment1:
                removeFragment("fragment1");
                break;
            case R.id.btn_replace_fragment2:
                fragment1 = new Fragment1();
                replaceFragment(R.id.fl_container,fragment1,"fragment1");
                break;
        }

    }


    private void addFragment(int layId,Fragment fragment,String Tag)
    {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layId,fragment,Tag);
        transaction.commit();
    }

    private void removeFragment(String Tag)
    {
        try {
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = manager.findFragmentByTag(Tag);
            if (fragment!=null) {
                transaction.remove(fragment);
                transaction.commit();
            }
            else
            {
                Toast.makeText(this,Tag+" is not exsit!",Toast.LENGTH_SHORT).show();

            }
        }
        catch(Exception e)
        {

        }
    }

    private void replaceFragment(int layId,Fragment fragment,String Tag)
    {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(layId,fragment,Tag);
        transaction.commit();
    }

}
