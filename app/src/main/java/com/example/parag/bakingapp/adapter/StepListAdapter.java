package com.example.parag.bakingapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.parag.bakingapp.R;
import com.example.parag.bakingapp.activities.SingleStepActivity;
import com.example.parag.bakingapp.fragments.RecipeFragment;
import com.example.parag.bakingapp.fragments.RecipeStepSinglePageFragment;
import com.example.parag.bakingapp.models.Step;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parag on 18-11-2017.
 */

public class StepListAdapter extends RecyclerView.Adapter<StepListAdapter.ViewHolder> {
    private List<Step> mSteps;
    private int mStepId;
    private int mRecipeId;
    private Context mContext;
    private String mName;
    OnStepListener mListener;

    public interface OnStepListener {
        void onStepSelected(View v, int position);
    }

    public StepListAdapter(List<Step> mSteps, OnStepListener listener, String recipeName, int recipeId) {
        this.mSteps = new ArrayList<>();
        this.mSteps.addAll(mSteps);
        this.mListener = listener;
        this.mName = recipeName;
        this.mRecipeId = recipeId;
    }

    @Override
    public StepListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StepListAdapter.ViewHolder holder, final int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(mSteps.get(position).getId());
        sb.append(". ");
        sb.append(mSteps.get(position).getShortDescription());

        holder.stepTextView.setText(sb);

        holder.stepTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStepId = mSteps.get(position).getId();
                Log.d("StepListAdapter", "StepID: " + mStepId + "RecipeID: " + mRecipeId);
                mListener.onStepSelected(view, position);

                    Intent intent = new Intent(mContext, SingleStepActivity.class);
                    Type type = new TypeToken<List<Step>>() {
                    }.getType();
                    String steps = new GsonBuilder().create().toJson(mSteps, type);
                    intent.putExtra(SingleStepActivity.STEPS, steps);
                    intent.putExtra("current_recipe", mName);
                    intent.putExtra("STEP_ID", mStepId);
                    mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mSteps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stepTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            stepTextView = itemView.findViewById(R.id.step_text_view);
        }
    }
}
