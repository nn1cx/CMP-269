import pandas as pd

def task_1_series_creation():
    print("--- Task 1: Building Series ---")
    lehman_buildings = {
        "Gillet": 4,
        "Carman": 3,
        "Music": 3,
        "Library": 4
    }
    s = pd.Series(lehman_buildings)
    print(s)
    pass

def task_2_dataframe_creation():
    print("\n--- Task 2: Course Database ---")
    data = {
        "Course Code": ["CMP 168", "CMP 269", "CMP 338"],
        "Credits": [4, 4, 4],
        "Enrolled": [25, 30, 20]
    }
    df = pd.DataFrame(data)
    print(df)
    pass

def task_3_data_manipulation():
    print("\n--- Task 3: Filtering and Math ---")
    data = {
        "Course Code": ["CMP 168", "CMP 269", "CMP 338"],
        "Credits": [4, 4, 4],
        "Enrolled": [25, 30, 20]
    }
    df = pd.DataFrame(data)
    filtered_df = df[df["Enrolled"] > 20]
    print(filtered_df)
    sum = df["Enrolled"].sum()
    print(f"Total Enrolled: {sum}")

def task_4_csv_integration():
    print("\n--- Task 4: Easy CSV I/O ---")
    data = {
        "Company Name": ["Apple Inc.", "Microsoft", "Tesla"],
        "Ticker": ["AAPL", "MSFT", "TSLA"],
        "Price": [287.46, 420.93, 411.89]
    }
    df = pd.DataFrame(data)
    df.to_csv("stocks.csv", index=False)
    df_loaded = pd.read_csv("stocks.csv")
    print(df_loaded)
    pass

if __name__ == "__main__":
    task_1_series_creation()
    task_2_dataframe_creation()
    task_3_data_manipulation()
    task_4_csv_integration()
    pass
