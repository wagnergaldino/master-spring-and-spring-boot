import './App.css';
import Counter from './component/Counter';

function App() {
  return (
    <div className='App'>
      <Counter/>
    </div>
  );
}

/*function PlayingWithProps({property1, property2}) {

  console.log(property1)
  console.log(property2)

  return (
    <div>props</div>
  )

}

function PlayingWithProps(properties) {

  console.log(properties)
  console.log(properties.property1)
  console.log(properties.property2)

  return (
    <div>props</div>
  )

}*/

export default App;
