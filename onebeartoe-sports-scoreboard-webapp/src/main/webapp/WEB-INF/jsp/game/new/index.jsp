
<div class="copyspace">
    <h3>Current Game</h3>
    <div class="featuredProject">
        <p>		
        <form method="POST" action="${pageContext.request.contextPath}/game/new">                    
            
            <br/>
            <input type="hidden" name="newSchedlue" value="${newSchedlue}"> 
            <pre>                    
                ${newGame}
            </pre>              

            Periods:
            <select name="periods" >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>            

            <br/>
            
            <br/>

            Period Length:
            <select name="periodLength" >
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
            </select>            

            <br/>
            
            <br/>
            <pre>                    
                
            </pre>              

            <input type="submit" value="New Game">
        </form>
        </p>
    </div>
    <br class="clearingBreak">
</div>

