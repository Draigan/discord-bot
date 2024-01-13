import { Button, TextField } from "@mui/material";
import Axios from "axios";

type PropsType = {
  triggerReload: Function;
  field: string;
  setField: Function;
};

export const Forms = ({ triggerReload, field, setField }: PropsType) => {
  function handleAdd() {
    Axios.post(
      "http://localhost:8080/photoz",
      {
        fileName: field,
      },
      {
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
      },
    )
      .then((result) => console.log(result))
      .then(() => triggerReload())
      .finally(() => setField(""));
  }
  function handleDelete() {}

  return (
    <div>
      <Button
        onClick={() => {
          handleAdd();
        }}
        variant="contained"
      >
        Add
      </Button>
      <Button onClick={handleDelete} variant="contained">
        Delete
      </Button>
      <TextField
        onChange={(e) => setField(e.target.value)}
        value={field}
        id="outlined-basic"
        label="Input Text"
        variant="outlined"
      />
    </div>
  );
};
