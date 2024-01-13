import { FormContainer } from "./components/FormContainer";
import { Upload } from "./components/file-uploader/Upload";

function App() {
  return (
    <div
      style={{
        width: "100%",
        height: "100vh",
        backgroundColor: "lightgray",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <FormContainer />
      <Upload />
    </div>
  );
}

export default App;
