import pandas as pd
import numpy as np

def get_messy_market_data():
    return pd.DataFrame({
        "Date": ["Mon", "Tue", "Wed", "Thu", "Fri"],
        "Open": [200.0, 202.5, np.nan, 201.0, 205.0],
        "Close": [203.0, np.nan, 199.0, 204.5, 208.0],
        "Volume": [1500000, 1800000, 1200000, np.nan, 2100000]
    })

def task_1_data_cleaning():
    print("--- Task 1: Data Cleaning ---")
    df = get_messy_market_data()
    cleaned_df = df

    print("Date Column: ", cleaned_df["Date"].isna().sum())
    print("Open Column: ", cleaned_df["Open"].isna().sum())
    print("Close Column: ", cleaned_df["Close"].isna().sum())
    print("Volume Column: ", cleaned_df["Volume"].isna().sum())
    cleaned_df["Volume"] = cleaned_df["Volume"].fillna(0)
    cleaned_df = cleaned_df.dropna()
    return cleaned_df

def task_2_volatility_filtering(clean_df):
    print("\n--- Task 2: Volatility Filtering ---")
    df = clean_df
    df["Price_Swing"] = df["Close"] - df["Open"]
    print(df[(df["Price_Swing"] > 2) | (df["Price_Swing"] < -2)])
    pass

def task_3_financial_summary(clean_df):
    print("\n--- Task 3: Financial Summary ---")
    df = clean_df

    print(df["Close"].describe())
    print("Max Volume: ", df["Volume"].max())
    pass

def task_4_algorithmic_metric(clean_df):
    print("\n--- Task 4: Algorithmic Metrics ---")
    df = clean_df
    df["Daily_Return"] = df["Close"].pct_change()
    df["2_Day_MA"] = df["Close"].rolling(2).mean()
    print(df)

if __name__ == "__main__":
    clean_df = task_1_data_cleaning()
    if clean_df is not None:
        task_2_volatility_filtering(clean_df.copy())
        task_3_financial_summary(clean_df.copy())
        task_4_algorithmic_metric(clean_df.copy())
    pass
