define(
    {
        "api_candy_sql": {
            "select_all_api": "SELECT * FROM apicandy_action",
            "select_param_by_action_id": "SELECT * FROM apicandy_param WHERE action_id = ?",
            "select_header_by_action_id": "SELECT * FROM apicandy_header WHERE action_id = ?",
            "select_result_by_action_id": "SELECT * FROM apicandy_result WHERE action_id = ?",
        }
    });