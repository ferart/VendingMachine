package arthur.mobileapps.com.vendingmachine.ui.views;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import arthur.mobileapps.com.vendingmachine.ApplicationManager;
import arthur.mobileapps.com.vendingmachine.R;
import arthur.mobileapps.com.vendingmachine.beans.ProductBean;
import arthur.mobileapps.com.vendingmachine.ui.presenter.ProductCardAdapter;
import arthur.mobileapps.com.vendingmachine.ui.presenter.VendingPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Main activity, it holds the grid view with each product
 *
 */
public class VendingActivity extends AppCompatActivity {

    //use of butterknife for binding the views
    @Bind(R.id.balance_summary_TV)
    TextView balanceSummaryTV; //balance of the user in the vending machine
    @Bind(R.id.vending_conf_TV)
    TextView configureTV;      //stock label
    @Bind(R.id.vending_summary_TV)
    TextView vendingSummaryTV; //label for the balance
    @Bind(R.id.products_grid)
    GridView productsGrid;     // grid view with the card of each product

    //dependency of the presenter for this UI activity
    @Inject
    VendingPresenter vendingPresenter;
    //adapter of the GridView
    ProductCardAdapter adapter;


    // variables for the menu drawer
    private DrawerLayout mDrawerLayout;         //drawer layout that contains a Listview
    private ListView mDrawerList;               // uses the OpcionAdapter
    private ActionBarDrawerToggle mDrawerToggle; //toggle for display th drawer
    public static OpcionAdapter opc_adapter;
    public static ArrayList<HashMap<String, String>> opcionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vending);

       /* AnimatorSet animator=(AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.alpha_changing);
        animator.setTarget(this);
        animator.start();
        */
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        ObjectAnimator anim = ObjectAnimator.ofFloat(viewGroup,"alpha",0.0f,1f);
        //anim.setRepeatCount(1);
        anim.setDuration(800); // duration 3 seconds
        anim.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vending, menu);
        ButterKnife.bind(this); //for butter knife to do the bindings

        //using dagger we inject the dependency  (the presenter)
        ((ApplicationManager)getApplication()).getUiComponent().inject(this);
        initUI();

        return true;
    }

    /**
     * Creates the drawer and initial configurations of the UI
     */
    private void initUI(){

        //display a button use for display the drawer in our case
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        //gets each view
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_menu_drawer);


        //when a new product is going to be purchased
        productsGrid.setOnItemClickListener(onClickProduct);

        //restock the vending machine
        List<ProductBean> products=vendingPresenter.fillListToAdapter();
        adapter= new ProductCardAdapter(this,products);
        productsGrid.setAdapter(adapter);

        //creates the drawer
        setupDrawer();
        updateBalanceSummary();
    }

    private void setupDrawer(){
        // Drawer init
        //  a new list of hashmaps that will contain the option about me
        opcionList = new ArrayList<HashMap<String, String>>();



        HashMap<String, String> opc_about = new HashMap<String, String>();
        //the option restock is added
        opc_about.put(OpcionAdapter.OPC_LABEL, getString(R.string.restock));
        opc_about.put(OpcionAdapter.OPC_IMAGE, Integer.toString(R.drawable.stock));
        // agregamos el HashMap a la Lista
        opcionList.add(opc_about);

        HashMap<String, String> opc_restock = new HashMap<String, String>();
        //the option about me is added
        opc_restock.put(OpcionAdapter.OPC_LABEL, getString(R.string.menu_about));
        opc_restock.put(OpcionAdapter.OPC_IMAGE, Integer.toString(R.drawable.importance_b));
        // agregamos el HashMap a la Lista
        opcionList.add(opc_restock);



        // the data is set to the opcionAdapter
        opc_adapter = new OpcionAdapter(this, opcionList);
        //set the optionAdapter to the list of the drawer
        mDrawerList.setAdapter(opc_adapter);
        mDrawerList.setOnItemClickListener(mOpcionClickListener);


        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer_white,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
//                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                supportInvalidateOptionsMenu();

            }
        };

        //set the drawer toggle to the drawer layout
        mDrawerLayout.setDrawerListener(mDrawerToggle);



    }

    /**
     * when back pressed is done.
     * if is into the fragment, remove it
     */
    @Override
    public void onBackPressed() {
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //when home button is selected
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mDrawerLayout.openDrawer(mDrawerList);
        }else if (id== R.id.action_exit){
            finish();
        }
        //when a new coin or dollar is inserted into the vending machine
        //the balance is updated
        else if (id== R.id.cent5){
           vendingPresenter.addCoins(.05f);
            updateBalanceSummary();
        }
        else if (id== R.id.cent25){
            vendingPresenter.addCoins(.25f);
            updateBalanceSummary();
        }else if (id== R.id.dolar1){
            vendingPresenter.addCoins(1f);
            updateBalanceSummary();
        }else if (id== R.id.dolar2){
            vendingPresenter.addCoins(2f);
            updateBalanceSummary();
        }else if (id== R.id.dolar5){
            vendingPresenter.addCoins(5f);
            updateBalanceSummary();
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * gets the balance of the vending machine and displays it
     */
    void updateBalanceSummary(){
        balanceSummaryTV.setText("$"+String.valueOf(vendingPresenter.getMoneyToSpend()));
    }


    /**
     * event listener when a new product is selected
     */
   GridView.OnItemClickListener onClickProduct=new GridView.OnItemClickListener(){

       @Override
       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


           //get the product selected
           ProductBean product=(ProductBean)productsGrid.getItemAtPosition(i);
           //update the stock
           //this is something to be done between the business and the DAO (Data access object) if the stock where maintain in a database
           if (product.getStock()>0) {
               product.setStock(product.getStock() - 1);
               adapter.notifyDataSetChanged();
           }

           //sells the product and displays the new balance
           vendingPresenter.sellProduct(VendingActivity.this,product);
           updateBalanceSummary();
       }
   };

    // el listener para on-click para todos las opciones del menu
    private AdapterView.OnItemClickListener mOpcionClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> av, View v, int position, long id) {


            switch (position) {
                case 0: //restock
                    mDrawerLayout.closeDrawer(mDrawerList);
                    List<ProductBean> products=vendingPresenter.fillListToAdapter();
                    adapter.clear();
                    adapter.addAll(products);
                    adapter.notifyDataSetChanged();
                    break;
                case 1:// about me
                    mDrawerLayout.closeDrawer(mDrawerList);
                    aboutDialog();  //display the custom alert dialog

                    break;
            }
        }
    };

    @OnClick({R.id.vending_conf_TV, R.id.vending_icon})
    public void clickStock(){

        vendingPresenter.openSlide(VendingActivity.this);
    }

    /**
     * About alert dialog to show info about me
     * Arthur Rocha
     */
    public void aboutDialog() {
        PackageInfo pinfo;
        String versionName = "";
        try {

            // obtenemos la información de la versión de la App
            pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            if (pinfo != null)
                versionName = pinfo.versionName;
            String content = "\n " + getString(R.string.aboout);



            final TextView message = new TextView(this);
            message.setText(content);
            message.setMovementMethod(LinkMovementMethod.getInstance());
            message.setTextColor(Color.parseColor("#000000"));

            final AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .create();

            // Setting Dialog Title
            alertDialog.setTitle(getString(R.string.app_name));

            // Setting Dialog Message
            alertDialog.setView(message);

            // Setting alert dialog icon
            alertDialog.setIcon(R.drawable.android_me);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

            // Showing Alert Message
            alertDialog.show();

        } catch (Exception e) {

        }

    }

}
