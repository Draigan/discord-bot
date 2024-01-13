type AppProps = {
  field: string;
  loading: boolean;
  setField: Function;
  data: dataType;
};
type dataType = dataArray | null;
type dataArray = Array<{
  id: string;
  fileName: string;
}>;

export const Display = ({ data, loading }: AppProps) => {
  if (!loading) {
    return (
      <>
        <ul>
          {data?.map((item, index) => {
            return <li key={index}>{item.fileName}</li>;
          })}
        </ul>
        LENGTH:{data?.length}
      </>
    );
  }
};
