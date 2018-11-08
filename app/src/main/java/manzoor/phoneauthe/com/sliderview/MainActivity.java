package manzoor.phoneauthe.com.sliderview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    RecyclerView recyclerView;
    Context context;
    private List<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        setupSlider();*/

       /* RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);*/
       recyclerView= (RecyclerView)findViewById(R .id.recyclerView);
       recyclerView.setHasFixedSize(true);
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
       recyclerView.setLayoutManager(linearLayoutManager);
       RecyclerViewAdapter adapter= new RecyclerViewAdapter(products);

       products = new ArrayList<>();
       products.add(new Product("Samsung",R.drawable.ic_launcher_foreground));
        products.add(new Product("Samsung",R.drawable.ic_launcher_foreground));
        products.add(new Product("Samsung",R.drawable.ic_launcher_foreground));
        products.add(new Product("Samsung",R.drawable.ic_launcher_foreground));
        products.add(new Product("Samsung",R.drawable.ic_launcher_foreground));

        recyclerView.setAdapter(adapter);

    }
 /*   private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }*/
 class Product{
     int imgId;
     String productName;
     Product(String productName,int imgId){
       this.productName = productName;
       this.imgId= imgId;
     }
 }
 // view the elements
 class  RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ProductViewHolder>{

     List<Product> products;

     public RecyclerViewAdapter(List<Product> products) {
         this.products = products;
     }
     public class ProductViewHolder extends RecyclerView.ViewHolder{
           CardView cardView;
           TextView productName;
           ImageView imgId;
         public ProductViewHolder(View itemView) {
             super(itemView);
             cardView =(CardView)itemView.findViewById(R.id.card_view);
             productName= (TextView) itemView.findViewById(R.id.txtCompanyName);
             imgId =(ImageView)itemView.findViewById(R.id.imgCard);
            // super(itemView);
         }
     }

     @NonNull
     @Override
     public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent,false);
         ProductViewHolder pvh= new ProductViewHolder(view);
         return pvh;
     }

     @Override
     public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productName.setText(products.get(position).productName);
        holder.imgId.setImageResource(products.get(position).imgId);
     }

     @Override
     public int getItemCount() {
         return products.size();
     }

 }
}
